<script setup>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import { ref, watch } from 'vue';
import { useAxios } from '@/composables/useAxios';

const emit = defineEmits(['updated'])

const visible = defineModel('visible')

const props = defineProps(['initial', 'url'])

const input = ref({
    nis: '',
    nama: ''
})
watch(props, (v) => input.value = v.initial)

const { fetch: editStudentRequest, loading } = useAxios(null, 'PUT', input)
const editStudentAction = async () => {
    await editStudentRequest(props.url)
    visible.value = false
    emit('updated')
}

</script>

<template>
    <Dialog v-model:visible="visible" header="Add Student">
        <div class="space-y-3 *:block mb-5">
            <InputText v-model="input.nis" name="title" placeholder="Nis" />
            <InputText v-model="input.nama" name="author" placeholder="Name" />
        </div>
        <Button @click="editStudentAction" :disabled="loading">Save</Button>
    </Dialog>
</template>