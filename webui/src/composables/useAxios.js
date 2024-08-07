import axios from "axios";
import { ref, toRef } from "vue";

export function useAxios(url, method = 'get', data = {}) {
    const input = toRef(data)
    const loading = ref(false)

    async function fetch(fetchUrl) {
        if (!fetchUrl) fetchUrl = url
        loading.value = true
        const res = await axios.request({url, method, data: input.value})
        loading.value = false
        return res
    }

    return { input, fetch, loading }
}