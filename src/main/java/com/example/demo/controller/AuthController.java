@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAccountRepository userRepo;
    private final JwtUtil jwt;

    @PostMapping("/login")
    public Map<String,String> login(@RequestBody Map<String,String> body){

        UserAccount u = userRepo.findAll().stream().findFirst().orElse(null);
        if(u == null) return Map.of("error","No user exists, create user first");

        String token = jwt.generateToken(u.getUsername(),u.getId(),u.getEmail(),u.getRole());

        return Map.of("token", token);
    }
}
