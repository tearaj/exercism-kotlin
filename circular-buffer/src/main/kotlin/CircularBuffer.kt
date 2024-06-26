
class EmptyBufferException: Exception()

class BufferFullException: Throwable()

class CircularBuffer<T>(val capacity:Int) {

    private var buffer = mutableListOf<T>()

    fun read() : T =
        if(buffer.size==0) throw EmptyBufferException()
        else buffer.removeFirst()


    fun write(value: T) =
        if(buffer.size==capacity) throw BufferFullException() else
        buffer.add(value)


    fun overwrite(value: T) {
        if(buffer.size==capacity) buffer.removeFirst()
        buffer.add(value)
    }

    fun clear() = buffer.clear()
}