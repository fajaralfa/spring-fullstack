import dayjs from "dayjs"

export const FORMAT = {
    DEFAULT: 'YYYY-MM-DD',
}
export const date = (str, format) => dayjs(str).format(format ?? FORMAT.DEFAULT)