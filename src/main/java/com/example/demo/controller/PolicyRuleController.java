import com.example.demo.entity.PolicyRule;
import com.example.demo.service.PolicyRuleService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.RequiredArgsConstructor;
import java.util.List;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RestController;

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
