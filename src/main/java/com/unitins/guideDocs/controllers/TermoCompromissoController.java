package com.unitins.guideDocs.controllers;

import com.unitins.guideDocs.models.Documento;
import com.unitins.guideDocs.models.ProcessoOrientacao;
import com.unitins.guideDocs.models.TipoDocumento;
import com.unitins.guideDocs.repository.PessoaRepository;
import com.unitins.guideDocs.repository.ProcessoOrientacaoRepository;
import com.unitins.guideDocs.util.Util;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
public class TermoCompromissoController {
    private final ProcessoOrientacaoRepository repository;
    private final PessoaRepository pessoaRepository;


    public TermoCompromissoController(ProcessoOrientacaoRepository repository, PessoaRepository pessoaRepository) {
        this.repository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    @RequestMapping(value = "/termoCompromisso", method = RequestMethod.GET)
    public String termoCompromisso(Model model) {
        Optional<ProcessoOrientacao> processoOrientacao = getProcessoOrientacao();

        model.addAttribute("orientador", processoOrientacao.get().getProfessorOrientador().getNome());
        model.addAttribute("orientando", processoOrientacao.get().getAluno().getNome());
        model.addAttribute("titulo", processoOrientacao.get().getTitulo());
        model.addAttribute("data", Util.getDateExtension(new Date()));

        Optional<Documento> doc = processoOrientacao.get().getDocumentos().stream().filter(documento -> documento.getTipoDocumento().equals(TipoDocumento.COMPROMISSOORIENTACAO)).findFirst();
        if (doc.isPresent()) {
            if (doc.get().isAssinadoAluno())
                model.addAttribute("dataAluno", Util.getDateExtension(doc.get().getDataAssinaturaAluno()));
            if (doc.get().isAssinadoProfessor())
                model.addAttribute("dataProfessor", Util.getDateExtension(doc.get().getDataAssinaturaProfessor()));
        }
        return "/aluno/termoCompromisso";
    }

    @RequestMapping(value = "/termoCompromisso", method = RequestMethod.POST)
    public ModelAndView assinarDocumento(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
        Optional<ProcessoOrientacao> processoOrientacao = getProcessoOrientacao();

        if (processoOrientacao.isPresent()) {
            Documento documento = new Documento();

            documento.setTipoDocumento(TipoDocumento.COMPROMISSOORIENTACAO);
            documento.setAssinadoAluno(true);
            documento.setDataAssinaturaAluno(new Date());

            ProcessoOrientacao orientacao = processoOrientacao.get();

            orientacao.getDocumentos().add(documento);

            orientacao.getAluno().setPermissions(orientacao.getAluno().getPermissions().concat(orientacao.getAluno().getPermissions().length() > 0 ? ",ASSINADO_ALUNO" : "ASSINADO_ALUNO"));

            pessoaRepository.save(orientacao.getAluno());
            repository.save(orientacao);
        }

        modelAndView.setViewName("termoCompromisso");

        return modelAndView;
    }

    private Optional<ProcessoOrientacao> getProcessoOrientacao() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        return repository.findByAlunoCpf(username);
    }

}
