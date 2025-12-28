@RestController
@RequestMapping("/rules")
@RequiredArgsConstructor
@SecurityRequirement(name="BearerAuth")
public class PolicyRuleController {

    private final PolicyRuleService ruleService;

    @PostMapping
    public PolicyRule create(@RequestBody PolicyRule rule){
        return ruleService.createRule(rule);
    }

    @GetMapping
    public List<PolicyRule> all(){
        return ruleService.getAllRules();
    }

    @GetMapping("/active")
    public List<PolicyRule> active(){
        return ruleService.getActiveRules();
    }
}
