public class Array<E> {

	private E[] elementData;

	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Array() {
		this(10);// Ĭ�����鳤��Ϊ10
	}

	public Array(int initialCapacity) {
		if (initialCapacity < 0)
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		elementData = (E[]) new Object[initialCapacity];
	}

	public int getSize() {
		return size;
	}

	public void add(E obj) {
		ensureCapacity();
		// �ȸ�ֵ������
		elementData[size++] = obj;
	}

	public void add(int index, E obj) {
		if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
		ensureCapacity();
		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size++;
	}

	public void addFirst(E e) {
		add(0,e);
	}
	public void addLast(E e) {
		add(size,e);
	}

	public E get(int index) {
		rangeCheck(index);
		return elementData[index];
	}
	
	public E getLast() {
		return get(size - 1);
	}
	
	public E getFirst() {
		return get(0);
	}

	public E remove(int index) {
		rangeCheck(index);
		// ɾ��ָ��λ�õĶ���
		E oldValue = elementData[index];
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		elementData[--size] = null;

		if (size == elementData.length / 4)
			resize(elementData.length / 2 + 1);// ���⵱elementData.length / 2 = 0�����

		return oldValue;
	}
	
	public E removeLast() {
		return remove(size - 1);
	}
	
	public E removeFirst() {
		return remove(0);
	}

	public void removeElement(Object obj) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(obj)) {// �ײ����equals()������==
				remove(i);
				return;
			}
		}
	}

	public E set(int index, E obj) {
		rangeCheck(index);
		E oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}

	private void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void ensureCapacity() {
		// �������ݺ����ݿ���
		if (size + 1 > elementData.length) {
			resize(size * 2 + 1);
		}
	}

	public int getCapacity() {
		return elementData.length;
	}

	private void resize(int newCapacity) {
		E[] newArray = (E[]) new Object[newCapacity];
		System.arraycopy(elementData, 0, newArray, 0, size);
		elementData = newArray;
	}
	
	@Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, elementData.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(elementData[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }


}
