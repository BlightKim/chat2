import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'
import viteTsconfigPaths from 'vite-tsconfig-paths'
import vitePluginSvgr from "vite-plugin-svgr";
import * as path from "path";

export default defineConfig({
    // depending on your application, base can also be "/"
    plugins: [react(), viteTsconfigPaths(), vitePluginSvgr()],
    server: {
        host: true,
        // this ensures that the browser opens upon server star
        port: 3000,
        watch: {
            usePolling: true
        }
    },
    resolve: {
        alias: {
            "@": path.resolve(__dirname, "/src"),
        }
    }
})