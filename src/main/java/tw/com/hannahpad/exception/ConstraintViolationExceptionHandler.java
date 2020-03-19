package tw.com.hannahpad.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ConstraintViolationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public String handleConstraint(ConstraintViolationException ex, RedirectAttributes redirectAttributes) {
        List<String> list = new ArrayList<>();
        for (ConstraintViolation<?> vvv : ex.getConstraintViolations()) {
            list.add(vvv.getInvalidValue().toString());
        }
        redirectAttributes.addAttribute("errMsg", String.join(",", list));
        return "redirect:/";
    }
}
