import axios from "axios";
import { ref } from "vue";

export function usePostBook() {
    const loading = ref(false)
    const input = ref({
        title: '',
        author: '',
        description: '',
    })

    async function submit() {
        loading.value = true
        const res = await axios.post('/api/v1/books', input.value)
        for(let key in input.value) input.value[key] = ''
        loading.value = false
        return res.data
    }

    return { input, submit, loading }
}