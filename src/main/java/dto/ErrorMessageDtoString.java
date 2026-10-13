package dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ErrorMessageDtoString {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
