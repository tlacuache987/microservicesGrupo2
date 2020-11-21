@Controller
public class HolaMundoCLIController{

	@GetMapping("/hello-world")
	@ResponseBody
	public String helloSpringCLI(){
		return "Hola Mundo Spring Boot CLI";
	}
}