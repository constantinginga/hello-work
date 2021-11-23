using System;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace WebApplication.Data
{
    public class WebApiUtil
    {
        private HttpClient _client;
        private string _url;

        public WebApiUtil(string url)
        {
            _client = new HttpClient();
            _url = url;
        }

        public async Task<string> Get(string args)
        {
            HttpResponseMessage responseMessage = await _client.GetAsync(_url + args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        public async Task<string> Post(string args, string body)
        {
            StringContent content = new StringContent(body, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await _client.PostAsync(_url + args, content);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }
        public async Task<string> Patch(string args, string body)
        {
            StringContent content = new StringContent(body, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await _client.PatchAsync(_url + args, content);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        public async Task<string> Delete(string args)
        {
            HttpResponseMessage responseMessage = await _client.DeleteAsync(_url + args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        public async Task<string> Get(string url, string args)
        {
            HttpResponseMessage responseMessage = await _client.GetAsync(url + args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        public async Task<string> Post(string url, string args, string body)
        {
            StringContent content = new StringContent(body, Encoding.UTF8, "application/json");
            HttpResponseMessage responseMessage = await _client.PostAsync(url + args, content);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }

            return await responseMessage.Content.ReadAsStringAsync();
        }

        public async Task Delete(string url, string args)
        {
            HttpResponseMessage responseMessage = await _client.DeleteAsync(url + args);
            if (!responseMessage.IsSuccessStatusCode)
            {
                throw new Exception($@"Error:{responseMessage.StatusCode}, {responseMessage.ReasonPhrase}");
            }
        }
    }
}