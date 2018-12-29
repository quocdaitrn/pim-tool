package vn.hcmut.ap.pim.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResponseMessage {
    private ResponseCode code;
    private String message;
}
