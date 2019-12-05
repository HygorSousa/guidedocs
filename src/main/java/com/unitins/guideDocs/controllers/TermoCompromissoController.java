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

import java.util.Collections;
import java.util.Date;
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
        if (processoOrientacao.isPresent()) {
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
        }
        return "/aluno/termoCompromisso";
    }

    @RequestMapping(value = "/termoCompromisso", method = RequestMethod.POST)
    public String assinarDocumento() {
        Optional<ProcessoOrientacao> processoOrientacao = getProcessoOrientacao();

        if (processoOrientacao.isPresent()) {
            Optional<Documento> documento = processoOrientacao.get().getDocumentos().stream().filter(doc -> doc.getTipoDocumento().equals(TipoDocumento.COMPROMISSOORIENTACAO)).findFirst();
            if (documento.isPresent()) {
                documento.get().setAssinadoAluno(true);
                documento.get().setDataAssinaturaAluno(new Date());
            } else {
                Documento documento1 = new Documento();

                documento1.setTipoDocumento(TipoDocumento.COMPROMISSOORIENTACAO);
                documento1.setAssinadoAluno(true);
                documento1.setDataAssinaturaAluno(new Date());

                processoOrientacao.get().getDocumentos().add(documento1);
            }

            ProcessoOrientacao orientacao = processoOrientacao.get();

            orientacao.getAluno().setPermissions(orientacao.getAluno().getPermissions().concat(orientacao.getAluno().getPermissions().length() > 0 ? ",ASSINADO_ALUNO" : "ASSINADO_ALUNO"));

            pessoaRepository.save(orientacao.getAluno());
            repository.save(orientacao);
        }

        Util.updateAuthorities(Collections.singletonList("ASSINADO_ALUNO"));

        return "redirect:/home";
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
