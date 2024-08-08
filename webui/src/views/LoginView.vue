<script setup>
import { useLogin } from '@/composables/useLogin.js'
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';

const { input, login, loading } = useLogin()

</script>

<template>
    <div class="p-20">
        <h2 class="text-xl mb-5">LOGIN</h2>
        <div class="mb-3 underline text-blue-600">
            <RouterLink :to="{ name: 'register' }">Register</RouterLink>
        </div>
        <form>
            <div class="space-y-3 *:block">
                <InputText v-model="input.username" type="text" name="username" id="username" />
                <InputText v-model="input.password" type="password" name="password" id="password" />
                <Button @click.prevent="login" :loading>Login</Button>
            </div>
        </form>
    </div>
</template>