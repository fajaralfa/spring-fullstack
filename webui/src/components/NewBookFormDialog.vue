<script setup>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import { ref } from 'vue';
import { useAxios } from '@/composables/useAxios';

const visible = ref(false)

const { input, fetch, loading } = useAxios('/api/v1/books', 'post', {
    title: '',
    author: '',
    description: '',
})

const emit = defineEmits(['result'])

async function storeNewBook() {
    const res = await fetch()
    emit('result', res.data)
    visible.value = false
}

</script>

<template>
    <Button @click="visible = true" severity="info">New Book</Button>
    <Dialog v-model:visible="visible" header="Create New Book">
        <div class="space-y-3 *:block mb-5">
            <InputText v-model="input.title" name="title" placeholder="Title" />
            <InputText v-model="input.author" name="author" placeholder="Author" />
            <InputText v-model="input.description" name="description" placeholder="Description" />
        </div>
        <Button @click="storeNewBook" :disabled="loading">Save</Button>
    </Dialog>
</template>