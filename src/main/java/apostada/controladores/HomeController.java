package apostada.controladores;

import apostada.entidades.Usuario;
import apostada.servicios.ApuestaService;
import apostada.servicios.PartidoService;
import apostada.servicios.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private ApuestaService apuestaService;
	
	@Autowired
	private PartidoService partidoService;
	
	@RequestMapping(value={"/", "/home",}, method=RequestMethod.GET)
	public String home(Model model) {
		Usuario usuario = sessionService.getUsuarioActual();
		model.addAttribute("usuario", usuario);
		model.addAttribute("num_apuestas", apuestaService.count());
		model.addAttribute("partidos", partidoService.findProximosPartidos());

		return "home";
	}
	
}
