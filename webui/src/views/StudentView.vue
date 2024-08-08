<script setup>
import { onBeforeMount, ref, watch } from 'vue';
import Button from 'primevue/button';
import { useAxios } from '@/composables/useAxios';
import NewStudentDialog from '@/components/NewStudentDialog.vue';
import EditStudentDialog from '@/components/EditStudentDialog.vue';

const { fetch, data } = useAxios('/api/v1/students')

const { fetch: deleteStudentRequest } = useAxios(null, 'DELETE')
const deleteStudentAction = async (url) => {
    if(!confirm('Delete this data?')) return
    await deleteStudentRequest(url)
    await fetch()
}

const editStudentProps = ref({
    initial: {},
    url: '',
})
const editStudentDialogVisible = ref(false)
const showEditStudentDialog = (student) => {
    editStudentProps.value.initial = {
        nis: student.nis,
        nama: student.nama,
    },
    editStudentProps.value.url = student._links.self.href
    editStudentDialogVisible.value = true
    
}

onBeforeMount(fetch)

</script>

<template>
    <div class="p-5">
        <NewStudentDialog @stored="fetch()" />
    </div>
    <div>
        <table class="w-1/2 m-auto table-fixed">
            <thead>
                <tr>
                    <th class="w-52">NIS</th>
                    <th>NAMA</th>
                    <th class="w-20"></th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="student in data?._embedded.students">
                    <td>{{ student.nis }}</td>
                    <td>{{ student.nama }}</td>
                    <Button @click="showEditStudentDialog(student)">X</Button>
                    <Button @click="deleteStudentAction(student._links.self.href)" severity="danger">X</Button>
                </tr>
            </tbody>
        </table>
    </div>
    <EditStudentDialog v-bind="editStudentProps" v-model:visible="editStudentDialogVisible" @updated="fetch()" />
</template>

<style scoped>
td, th, tr {
    @apply border;
}
</style>