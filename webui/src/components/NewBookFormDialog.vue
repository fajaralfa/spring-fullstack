<script setup>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import { ref } from 'vue';
import { usePostBook } from '@/composables/usePostBook';

const { input, submit, loading } = usePostBook()
const emit = defineEmits(['stored'])

const visible = ref(false)

const storeNewBook = async () => {
    await submit()
    emit('stored')
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