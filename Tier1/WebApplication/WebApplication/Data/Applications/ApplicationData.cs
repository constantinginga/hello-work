using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Newtonsoft.Json;
using WebApplication.Models;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace WebApplication.Data.Applications
{
    public class ApplicationData : IApplicationData
    {
        private WebApiUtil _client;
        private const string _url = "http://localhost:8082/application";
        private const string _urlFile = "http://localhost:8082/file";

        private const string _fileArgs = "?id=%id%&name=%name%";


        public IList<Application> Applications { get; private set; }

        public ApplicationData()
        {
            _client = new(_url);
            Applications = new List<Application>();
        }

        public async Task<Application> AddApplication(Application application)
        {
            // store locally
            Applications.Add(application);

            // store in web api
            string applicationJson = JsonSerializer.Serialize(application);
            string response = await _client.Post("", applicationJson);
            Application applicationResponse = JsonSerializer.Deserialize<Application>(response,
                new JsonSerializerOptions()
                {
                });
            return applicationResponse;
        }

        public async Task<IList<Application>> GetApplications()
        {
            string responese = await _client.Get("");
            Applications = JsonSerializer.Deserialize<List<Application>>(responese, new JsonSerializerOptions
            {
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });
            return Applications;
        }

        public async void UploadFile(int applicationId, string fileName, string file)
        {
            _client.Post(_urlFile,
                _fileArgs.Replace("%id%", applicationId.ToString()).Replace("%name%", fileName), file);
        }

        public async Task<string>  GetFile(int applicationId, string fileName)
        {
            return await _client.Get(_urlFile,
                _fileArgs.Replace("%id%", applicationId.ToString()).Replace("%name%", fileName));
        }

        public async Task UpdateApplication(Application application)
        {
            string applicationJson = JsonSerializer.Serialize(application);
            string response = await _client.Patch("", applicationJson);
        }
    }
}