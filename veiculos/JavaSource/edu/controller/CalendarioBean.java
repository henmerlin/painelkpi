package edu.controller;

import java.util.Calendar;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CalendarioBean {

	private Calendar calendar;

	public CalendarioBean() {

	}

	public Integer getAnoAtual() {
		this.calendar = Calendar.getInstance();
		Integer ano = this.calendar.get(Calendar.YEAR);
		return ano;
	}

}
