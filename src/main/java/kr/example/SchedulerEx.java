package kr.example;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;


public class SchedulerEx {

	public static void main(String[] args) {
		
		Publisher<Integer> pub = sub -> {
			sub.onSubscribe(new Subscription() {
				
				@Override
				public void request(long n) {
					sub.onNext(1);
					sub.onNext(2);
					sub.onNext(3);
					sub.onNext(4);
					sub.onNext(5);
					sub.onComplete();
				}
				
				@Override
				public void cancel() {
					// TODO Auto-generated method stub
				}
			});
		};
		
		pub.subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription s) {
				s.request(Long.MAX_VALUE);
			}

			@Override
			public void onNext(Integer i) {
				System.out.println("onNext:" + i);
			}

			@Override
			public void onError(Throwable throwable) {
				
			}

			@Override
			public void onComplete() {
				System.out.println("onComplete");
			}
		});
	}
	
}
