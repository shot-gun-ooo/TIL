const fs = require('fs').promises;
async function readdirAsync() {
  try {
    const files = await fs.readdir('./');
    console.log(files);
  } catch {
    console.error(err);
  }
}
readdirAsync()