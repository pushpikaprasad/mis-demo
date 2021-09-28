package lk.ac.pdn.eng.mis.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class errorController implements ErrorController {
	
	private final static String PATH = "/error";
	@Override
    @RequestMapping(PATH)
    @ResponseBody
    public String getErrorPath() {
        return "<!DOCTYPE html>\r\n"
        		+ "<html>\r\n"
        		+ "<head>"
        		+ "<meta charset=\"ISO-8859-1\">\r\n"
        		+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
        		+ "<title>MIS</title>\r\n"
        		+ "<!-- Compiled and minified CSS -->\r\n"
        		+ "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\r\n"
        		+ "\r\n"
        		+ "    <!-- Compiled and minified JavaScript -->\r\n"
        		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\r\n"
        		+ "     "
        		+ "</head>"
        		+ "<body>\r\n"
        		+ "<div style=\"margin: 10% 15% 20% 15%; \"  >"
        		+ "<div class=\"row container\">"
        		+ "<div class=\" card z-depth-5 col s12 m12 l12\">"
        		+ 	"<div class=\"card-content\">"
        		+ 		"<span class=\"card-title\">Something went wrong!</span>"
        		+ 		"<p><b>Please try again!</b>. <br><br>Or contact system admin.</p>\r\n"
        		+ 	"</div>"
        		+ 	"<div class=\"card-action\">"
        		+ 		"<a href=\"/login\">Login</a>\r\n"
        		+ 	"</div>"
        		+ "</div>"
        		+ "</div>"
        		+ "</div>"
        		+ "</body>\r\n"
        		+ "</html>";
    }
	
}
	


