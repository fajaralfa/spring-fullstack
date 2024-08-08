<script setup>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import { ref } from 'vue';
import { useAxios } from '@/composables/useAxios';

const emit = defineEmits(['stored'])

const visible = ref(false)

const input = ref({
    nis: '',
    nama: ''
})
const { fetch: postStudentRequest, loading } = useAxios('/api/v1/students', 'POST', input)
const postStudentAction = async () => {
    await postStudentRequest()
    visible.value = false
    emit('stored')
}

</script>

<template>
    <Button @click="visible = true" severity="info">Add Student</Button>
    <Dialog v-model:visible="visible" header="Add Student">
        <div class="space-y-3 *:block mb-5">
            <InputText v-model="input.nis" name="title" placeholder="Nis" />
            <InputText v-model="input.nama" name="author" placeholder="Name" />
        </div>
        <Button @click="postStudentAction" :disabled="loading">Save</Button>
    </Dialog>
</template>