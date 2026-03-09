@Controller
public class TestController {

    @GetMapping("/")
    @ResponseBody
    public String test(){
        return "App is running!";
    }

}