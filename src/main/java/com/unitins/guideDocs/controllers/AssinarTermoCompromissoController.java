package com.unitins.guideDocs.controllers;

import com.unitins.guideDocs.models.Documento;
import com.unitins.guideDocs.models.ProcessoOrientacao;
import com.unitins.guideDocs.models.TipoDocumento;
import com.unitins.guideDocs.repository.PessoaRepository;
import com.unitins.guideDocs.repository.ProcessoOrientacaoRepository;
import com.unitins.guideDocs.util.Util;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Controller
public class AssinarTermoCompromissoController {
    private final ProcessoOrientacaoRepository processoOrientacaoRepository;
    private final PessoaRepository pessoaRepository;


    public AssinarTermoCompromissoController(ProcessoOrientacaoRepository repository, PessoaRepository pessoaRepository) {
        this.processoOrientacaoRepository = repository;
        this.pessoaRepository = pessoaRepository;
    }

    @RequestMapping(value = "/listarTermosAssinar", method = RequestMethod.GET)
    public String listarTermosAssinar(Model model) {
        model.addAttribute("processos", processoOrientacaoRepository.findAll());
        return "/professor/listarTermosAssinar";
    }

    @RequestMapping(value = "/assinar_termo", method = RequestMethod.GET)
    public String handleAssinarTermo(@RequestParam(name = "idprocesso") Integer idprocesso) {

        Optional<ProcessoOrientacao> processoOrientacao = processoOrientacaoRepository.findById(idprocesso);

        if (processoOrientacao.isPresent()) {
            Optional<Documento> documento = processoOrientacao.get().getDocumentos().stream().filter(doc -> doc.getTipoDocumento().equals(TipoDocumento.COMPROMISSOORIENTACAO)).findFirst();
            if (documento.isPresent()) {
                documento.get().setAssinadoProfessor(true);
                documento.get().setDataAssinaturaProfessor(new Date());
            } else {
                Documento documento1 = new Documento();

                documento1.setTipoDocumento(TipoDocumento.COMPROMISSOORIENTACAO);
                documento1.setAssinadoProfessor(true);
                documento1.setDataAssinaturaProfessor(new Date());

                processoOrientacao.get().getDocumentos().add(documento1);
            }

            ProcessoOrientacao orientacao = processoOrientacao.get();

            orientacao.getAluno().setPermissions(orientacao.getAluno().getPermissions().concat(orientacao.getAluno().getPermissions().length() > 0 ? ",ASSINADO_PROFESSOR" : "ASSINADO_PROFESSOR"));

            pessoaRepository.save(orientacao.getAluno());
            processoOrientacaoRepository.save(orientacao);
        }

        Util.updateAuthorities(Collections.singletonList("ASSINADO_PROFESSOR"));

        return "redirect:/home";
    }
}
