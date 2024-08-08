import axios from "axios";
import { ref, toRef } from "vue";

export function useAxios(url, method = 'get', input) {
    const loading = ref(false)
    const data = ref()

    async function fetch(reqUrl) {
        if (reqUrl) url = reqUrl
        loading.value = true
        const res = await axios.request({url, method, data: input?.value})
        data.value = res.data
        loading.value = false
    }

    return { fetch, data, loading }
}