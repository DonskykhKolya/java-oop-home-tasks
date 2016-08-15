package com.shpach.multyTread;

public class SingleThreadSorting implements Runnable {
	public enum Method {
		simple, shell
	};

	private int[] array;
	private int begin;
	private int end;
	private Thread thr;
	private int index;
	private boolean stop = false;
	private Method type;

	public SingleThreadSorting(int[] array, int begin, int end, Method type) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
		this.index = begin;
		this.type = type;
	}

	public Thread getThr() {
		return thr;
	}

	public int peekElement() {
		return array[index];
	}

	public int pollElement() {
		int temp = array[index];
		check();
		return temp;
	}

	public boolean isStop() {
		return stop;
	}

	@Override
	public void run() {
		switch (this.type) {
		case shell:
			shellSort();
			break;
		case simple:
			simpleSort();
			break;
		default:
			simpleSort();
		}
		simpleSort();
	}

	private void simpleSort() {
		int temp;
		for (int i = begin; i < end; i++) {
			int k = i - 1;
			temp = array[i];
			for (; k >= begin && array[k] > temp;) {
				array[k + 1] = array[k];
				array[k] = temp;
				k--;
			}
		}
	}

	private void shellSort() {
		int t;
		// int n=array.length;
		int n = this.end - this.begin;
		for (int k = n / 2; k > 0; k /= 2)
			for (int i = k + this.begin; i < n + this.begin; i += 1) {
				t = array[i];
				int j;
				for (j = i; j >= k; j -= k) {
					if (t < array[j - k])
						array[j] = array[j - k];
					else
						break;
				}
				array[j] = t;
			}
	}

	private void check() {
		this.index++;
		if (this.index >= this.end) {
			this.stop = true;
		}
	}
}
