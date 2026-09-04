package com.ram.java.solid.openclosedprinciple;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Class that holds Internet session history
 */
public class InternetSessionHistory {
	
	private static final Map<Long, List<InternetSession>> SESSIONS = new HashMap<>();
	
	public synchronized static List<InternetSession> getCurrentSessions(long subscriberId) {
		return SESSIONS.containsKey(subscriberId) ? SESSIONS.get(subscriberId) : Collections.emptyList();
	}
	
	public synchronized static void addSession(long subscriberId, LocalDateTime begin, long dataUsed) {
		List<InternetSession> sessions;
		
		if (!SESSIONS.containsKey(subscriberId)) {
			sessions = new LinkedList<>();
			SESSIONS.put(subscriberId, sessions);
		} else {
			sessions = SESSIONS.get(subscriberId);
		}
		
		sessions.add(new InternetSession(subscriberId, begin, dataUsed));
	}

	public static class InternetSession {
		
		private long subscriberId;
		
		private LocalDateTime begin;
		
		private long dataUsed;

		public InternetSession(long subscriberId, LocalDateTime begin, long dataUsed) {
			this.subscriberId = subscriberId;
			this.begin = begin;
			this.dataUsed = dataUsed;
		}

		/**
		 * @return the subscriberId
		 */
		public long getSubscriberId() {
			return subscriberId;
		}

		/**
		 * @return the begin
		 */
		public LocalDateTime getBegin() {
			return begin;
		}

		/**
		 * @return the dataUsed
		 */
		public long getDataUsed() {
			return dataUsed;
		}
	}

}
