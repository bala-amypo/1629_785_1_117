@RestController
@RequestMapping("/logins")
@RequiredArgsConstructor
@SecurityRequirement(name = "BearerAuth")
public class LoginEventController {

    private final LoginEventService loginEventService;

    @PostMapping("/{userId}")     // <<< userId comes from URL
    public LoginEvent record(@PathVariable Long userId,
                             @RequestBody LoginEvent event){
        return loginEventService.recordLogin(userId, event);
    }

    @GetMapping("/{userId}")
    public List<LoginEvent> userEvents(@PathVariable Long userId){
        return loginEventService.getEventsByUser(userId);
    }

    @GetMapping("/{userId}/failed")
    public List<LoginEvent> suspicious(@PathVariable Long userId){
        return loginEventService.getSuspiciousLogins(userId);
    }
}
