<script setup>
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import { watch } from 'vue';
import { useEditBook } from '@/composables/useEditBook';

const props = defineProps({
    data: Object
})

const visible = defineModel('visible')

const emit = defineEmits(['updated'])

const { input, submit, loading } = useEditBook()

const updateBook = async () => {
    await submit(props.data.link)
    emit('updated')
    visible.value = false
}

watch(props.data, (v) => input.value = props.data.data)

</script>

<template>
    <Dialog header="Edit Book" v-model:visible="visible">
        <div class="space-y-3 *:block mb-5">
            <InputText v-model="input.title" name="title" placeholder="Title" />
            <InputText v-model="input.author" name="author" placeholder="Author" />
            <InputText v-model="input.description" name="description" placeholder="Description" />
        </div>
        <Button @click="updateBook" :disabled="loading">Update</Button>
    </Dialog>
</template>