package org.sopt.collaboration.domain.club.service.util;

import java.time.LocalDate;

public class DeadlineUtil {
	public static LocalDate getAfterDeadline(DeadlineType deadlineType) {
		if (deadlineType == null)
			return null;

		if (deadlineType == DeadlineType.OVER7
			|| deadlineType == DeadlineType.OVER14
			|| deadlineType == DeadlineType.OVER30) {
			return LocalDate.now().plusDays(deadlineType.getDay());
		}
		return null;
	}

	public static LocalDate getBeforeDeadline(DeadlineType deadlineType) {
		if (deadlineType == null)
			return null;

		if (deadlineType == DeadlineType.UNDER7) {
			return LocalDate.now().plusDays(deadlineType.getDay());
		}
		return null;
	}
}
