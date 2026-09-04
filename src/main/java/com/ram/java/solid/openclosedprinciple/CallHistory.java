package com.ram.java.solid.openclosedprinciple;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Responsible for maintaining record of calls
 * and the respective call history, along with
 * duration, beginning time, and subscriber's ID.
 */
public class CallHistory {
	
private static final Map<Long, List<Call>> CALLS = new HashMap<>();
	
	public synchronized static List<Call> getCurrentCalls(long subscriberId) {
		return CALLS.containsKey(subscriberId) ? CALLS.get(subscriberId) : Collections.emptyList();
	}
	
	public synchronized static void addSession(long subscriberId, LocalDateTime begin, long duration) {
		List<Call> calls;
		
		if (!CALLS.containsKey(subscriberId)) {
			calls = new LinkedList<>();
			CALLS.put(subscriberId, calls);
		} else {
			calls = CALLS.get(subscriberId);
		}
		
		calls.add(new Call(subscriberId, begin, duration));
	}

	public static class Call {
		
		private long subscriberId;
		
		private LocalDateTime begin;
		
		private long duration;

		public Call(long subscriberId, LocalDateTime begin, long dataUsed) {
			this.subscriberId = subscriberId;
			this.begin = begin;
			this.duration = dataUsed;
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
			return duration;
		}
	}
}
