import axios from "axios"
import { ref } from "vue"

export function useEditBook() {
    const input = ref({})
    const loading = ref(false)

    async function submit(url) {
        loading.value = true
        const res = axios.put(url, input.value)
        loading.value = false
    }

    return { input, submit, loading }
}