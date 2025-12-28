@RestController
@RequestMapping("/violations")
@RequiredArgsConstructor
@SecurityRequirement(name="BearerAuth")
public class ViolationRecordController {

    private final ViolationRecordService violationService;

    @PostMapping
    public ViolationRecord log(@RequestBody ViolationRecord v){
        return violationService.logViolation(v);
    }

    @GetMapping("/unresolved")
    public List<ViolationRecord> unresolved(){
        return violationService.getUnresolvedViolations();
    }

    @PutMapping("/{id}/resolve")
    public ViolationRecord resolve(@PathVariable Long id){
        return violationService.markResolved(id);
    }
}
