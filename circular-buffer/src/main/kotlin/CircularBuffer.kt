import kotlin.collections.ArrayDeque

// TODO: implement proper exceptions to complete the task
class EmptyBufferException: Exception()

class BufferFullException: Throwable()

class CircularBuffer<T>(val capacity:Int) {

    private var buffer:ArrayDeque<T> = ArrayDeque(capacity)
    private var currLocation = 0

    fun read() : T =
        if(buffer.size==0) throw EmptyBufferException()
        else buffer.removeFirst()


    fun write(value: T) {
        if(buffer.size==capacity) throw BufferFullException()
        buffer.addLast(value)

    }

    fun overwrite(value: T) {
        if(buffer.size==capacity) buffer.removeFirst()
        buffer.addLast(value)
    }

    fun clear() {
        buffer.clear()
    }
}