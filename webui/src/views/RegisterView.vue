<script setup>
import { useAxios } from '@/composables/useAxios';
import Button from 'primevue/button';
import InputText from 'primevue/inputtext';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter()

const input = ref({
    name: '',
    username: '',
    password: '',
})

const { fetch, loading } = useAxios('/api/v1/auth/signup', 'POST', input)
const register = async () => {
    await fetch()
    router.push({name: 'login'})
}

</script>

<template>
    <div class="p-20">
        <h2 class="text-xl mb-5">REGISTER</h2>
        <div class="mb-3 underline text-blue-600">
            <RouterLink :to="{ name: 'login' }">Login</RouterLink>
        </div>
        <form>
            <div class="space-y-3 *:block">
                <InputText v-model="input.name" type="text" name="name" id="name" />
                <InputText v-model="input.username" type="text" name="username" id="username" />
                <InputText v-model="input.password" type="password" name="password" id="password" />
                <Button @click.prevent="register" :loading>Register</Button>
            </div>
        </form>
    </div>
</template>