package hi1237.hello.spring4.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board {

    private String bno;
    private String title;
    private String userid;
    private String regdate;
    private String views;
    private String contents;


}
