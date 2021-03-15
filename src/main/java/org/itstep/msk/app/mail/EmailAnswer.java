package org.itstep.msk.app.mail;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmailAnswer {
    @NotNull
    private String name;
    @NotNull
  //  @Email
    private String email;

    @NotNull
    @Min(10)
    private String answer;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
