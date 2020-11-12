package com.gdula.polybiusCypher;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/encrypt")
public class EncryptController {

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("wordToBeEncrypted", new WordToBeEncrypted());

        return "encryptForm";
    }

    @PostMapping
    public String processOrder(WordToBeEncrypted wordToBeEncrypted, Model model) {
        Polybius polybius = new Polybius();
        String encryptedWord = polybius.polybiusCipher(wordToBeEncrypted.getWord());
        model.addAttribute("encryptedWord", encryptedWord);


        return "result";
    }

}
