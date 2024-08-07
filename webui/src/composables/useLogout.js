import { useAuth } from '@/stores/auth';
import { useRouter } from 'vue-router';

export function useLogout() {
    const auth = useAuth()
    const router = useRouter()

    function logout() {
        if (confirm('Logout?')) {
            auth.logout()
            router.replace({ name: 'login' })
        }
    }

    return { logout }
}