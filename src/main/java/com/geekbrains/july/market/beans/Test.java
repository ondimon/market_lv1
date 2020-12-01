package com.geekbrains.july.market.beans;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Component
@SessionScope
public class Test implements Serializable {
    Integer count = 0;
}
