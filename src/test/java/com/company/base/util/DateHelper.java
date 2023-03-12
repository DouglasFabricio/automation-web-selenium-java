package com.company.base.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// TODO Adicionar comentário e log4j.
public class DateHelper {
	
	public static LocalTime timeNow;
	public static String unidade;
	public static String atendimento;
	public static boolean timeStart = false;
	private static long aguardar;

	public static String getUnidade() {
		return unidade;
	}

	public static void setUnidade(String unidade) {
		DateHelper.unidade = unidade;
	}

	public static String getAtendimento() {
		return atendimento;
	}

	public static void setAtendimento(String atendimento) {
		DateHelper.atendimento = atendimento;
	}

	public static LocalDate getDateNow() {

		LocalDate now = LocalDate.now();



		return now;
	}

	public static String formatDate(LocalDate date) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String format = date.format(formatador);
		return format;
	}

	public static String getFormatDateNow() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.now().format(formatador);
	}

	public static String formatDate(LocalDate date, String pattern) {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern(pattern);
		return date.format(formatador);
	}

	public static LocalDate datePlusDays(LocalDate date, int days) {
		return date.plusDays(days);
	}

	public static LocalTime getTime(int hour, int minute) {
		return LocalTime.of(hour, minute);
	}

	public static LocalTime getTimeNow() {
		return LocalTime.now();
	}

	public static LocalTime stringToTime(String date) {
		return LocalTime.parse(date);
	}

	public static String formatTime(LocalTime time) {
		return time.format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	/**
	 * wait time
	 *
	 * @author weslley.oliveira
	 * @since 09/11/2018
	 *
	 * @param time
	 * @return
	 */
	public static boolean waitTime(long time, long currentTime){
		aguardar = currentTime + time;

		return System.currentTimeMillis() < aguardar;
	}

	/**
	 * wait thread sleep
	 *
	 * @author weslley.oliveira
	 * @since 09/11/2018
	 *
	 * @param time
	 */
	public static void waitThread(long time){
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static LocalDate parseFromString(String date){
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

}
