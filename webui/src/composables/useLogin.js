import { useAuth } from "@/stores/auth";
import { ref } from "vue";
import { useRouter } from "vue-router";

export function useLogin() {
    const loading = ref(false)
    const input = ref({
        username: '',
        password: '',
    })
    
    const auth = useAuth()
    const router = useRouter()
    
    async function login() {
        loading.value = true
        await auth.login(input.value)
        loading.value = false
        router.push({name: 'home'})
    }

    return { input, login, loading }
}