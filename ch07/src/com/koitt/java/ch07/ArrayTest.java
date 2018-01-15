package com.koitt.java.ch07;

public class ArrayTest {
	
	private Integer[] array;	// 데이터를 담는 자료구조
	private int size;			// 배열의 크기
	private int length;			// 실제 데이터의 개수
	
	public ArrayTest(int size) {
		this.size = size;
		this.array = new Integer[this.size];
	}
	
	// 자료구조에 데이터를 추가 (index 번호에다가 해당 데이터를 저장)
	public void add(int index, int value) {
		if (index >= 0 && index < this.size) {
			if (this.array[index] == null) {
				this.array[index] = value;
			}
			else if (this.array[index] != null) {
				int newSize = this.size + 1;
				if (this.array.length < newSize) {
					// 깊은복사(Deep copy): 기존 데이터를 손상없이 보존하기 위해서 임시로 다른 배열에 값을 복사
					Integer[] tempArray = new Integer[this.size];
					System.arraycopy(this.array, 0, tempArray, 0, this.array.length);
					
					// 
					this.size *= 2;
					this.array = new Integer[this.size];
					System.arraycopy(tempArray, 0, this.array, 0, tempArray.length);
				}
				
				// 집어 넣으려는 index번호 뒤쪽 데이터를 한칸씩 뒤로 이동
				System.arraycopy(this.array, index, this.array, index + 1, this.length - index);
				
				this.array[index] = value;	// 새로 추가하려는 값을 배열에 저장
				this.length += 1;			// 기존 데이터 개수 + 새로운 데이터 개수
			}
		}
	}
	
	public void remove(int index) {
		if (index >= 0 && index < this.size) {
			
		}
	}
	
	public void set(int index, int value) {
		
	}
	
	public Integer[] getArray() {
		return array;
	}
	
	public int getLength() {
		return length;
	}

	public static void main(String[] args) {
		ArrayTest test = new ArrayTest(3);
		test.add(0, 2);
		for (int i = 0; i < test.getLength(); i++) {
			
		}
		test.add(0, 3);
		test.add(0, 4);
		test.add(1, 1);	
	}
}
