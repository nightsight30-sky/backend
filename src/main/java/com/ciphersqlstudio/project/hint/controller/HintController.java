package com.ciphersqlstudio.project.hint.controller;

import com.ciphersqlstudio.project.hint.dto.HintRequest;
import com.ciphersqlstudio.project.hint.dto.HintResponse;
import com.ciphersqlstudio.project.hint.service.HintService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hints")
public class HintController {

    private final HintService hintService;

    public HintController(HintService hintService) {
        this.hintService = hintService;
    }

    @PostMapping
    public HintResponse getHint(@RequestBody HintRequest request) {
        String hint = hintService.getHint(request);
        return new HintResponse(hint);
    }
}
