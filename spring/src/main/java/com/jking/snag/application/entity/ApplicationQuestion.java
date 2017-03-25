package com.jking.snag.application.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

/**
 * Created by john on 3/25/17.
 */
@Data
@Wither
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class ApplicationQuestion {
    String id;
    String answer;
}
