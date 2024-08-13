package org.esfeprueba.controladores;

import org.esfeprueba.modelos.Docente;
import org.esfeprueba.modelos.Grupo;
import org.esfeprueba.servicios.interfaces.IDocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/docentes")
public class DocenteController {
    @Autowired
    private IDocenteService docenteService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size)
    {
        int currentPage = page.orElse(1) - 1;
        int pageSize = size.orElse(5);
        Pageable pageable = PageRequest.of(currentPage, pageSize);

        Page<Docente> docentes = docenteService.buscarTodosPaginados(pageable);
        model.addAttribute("docentes", docentes);

        int totalPage = docentes.getTotalPages();
        if(totalPage > 0)
        {
            List<Integer> pageNumber = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumber);
        }
        return "docente/index";
    }

    @GetMapping("/create")
    public String create(Docente docente)
    {
        return "docente/create";
    }

    @PostMapping("/save")
    public String save(Docente pDocente, BindingResult result, Model model, RedirectAttributes attributes)
    {
        if(result.hasErrors())
        {
            model.addAttribute(pDocente);
            return "docente/create";
        }

        docenteService.guardarOEditar(pDocente);
        attributes.addFlashAttribute("msg", "Docente Creado Correctamente");
        return "redirect:/docentes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model)
    {
        Docente docente = docenteService.obtenerPorId(id).get();
        model.addAttribute("docente", docente);
        return "docente/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        Docente docente = docenteService.obtenerPorId(id).get();
        model.addAttribute("docente", docente);
        return "docente/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model)
    {
        Docente docente = docenteService.obtenerPorId(id).get();
        model.addAttribute("docente", docente);
        return "docente/delete";
    }

    @PostMapping("/delete")
    public String delete(Grupo grupo, RedirectAttributes attributes)
    {
        docenteService.eliminarPorId(grupo.getId());
        attributes.addFlashAttribute("msg", "Docente eliminado correctamente");
        return "redirect:/docentes";
    }
}
