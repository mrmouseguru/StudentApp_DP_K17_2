package vn.edu.giadinh.business;

import java.util.ArrayList;
import java.util.List;

import vn.edu.giadinh.persistence.Subscriber;

public class Publisher {
	private List<Subscriber> subscribers = new ArrayList<>();

	public void registerSubscriber(Subscriber sub) {
		
		this.subscribers.add(sub);

	}

	public void removeSubscriber(Subscriber sub) {
		this.subscribers.remove(sub);

	}

	public void notifySubscribers() {
		
		for (Subscriber subscriber : subscribers) {
			subscriber.update();
		}

	}

}
