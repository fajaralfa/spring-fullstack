<script setup>
import { useLogin } from '@/composables/useLogin.js'
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';

const { input, login, loading } = useLogin()

</script>

<template>
    <div class="p-20">
        <form>
            <div class="space-y-3 *:block">
                <InputText v-model="input.username" type="text" name="username" id="username" />
                <InputText v-model="input.password" type="password" name="password" id="password" />
                <Button @click.prevent="login" :loading>Login</Button>
            </div>
        </form>
    </div>
</template>