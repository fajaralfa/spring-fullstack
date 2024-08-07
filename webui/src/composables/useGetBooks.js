import axios from "axios";
import { ref } from "vue";

export function useGetBooks() {
    const loading = ref(false)
    const books = ref([])

    async function fetch() {
        loading.value = true
        const res = await axios.get('/api/v1/books')
        books.value = res.data._embedded.books
        loading.value = false
    }

    return { books, fetch, loading }
}